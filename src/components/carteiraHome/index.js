import React, { useState, useContext, useEffect, useCallback } from "react";
import { View, Text, TouchableOpacity, Image, VirtualizedList, SafeAreaView } from "react-native";
import { AuthContext } from "../../context/auth";
import { useNavigation, useFocusEffect } from "@react-navigation/native";
import blogFetch from "../../axios/config";

import styles from './style';

export default function CarteiraHome() {
    //função usada em botões para trocar de tela
    const navigation = useNavigation();
    //const [textButton, setTextButton] = useState("Acessar");
    const { idToken, setIdcadastro, setNome } = useContext(AuthContext);
    const [dados, setDados] = useState();
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(false);

    async function getDados(){
        try {
            const response = await blogFetch.get(`cadastros/conta/${idToken}`);
            setDados(response.data);          
        } catch (error) {
            console.log(error);//pode apagar
            setError(true);
        } finally {
            setLoading(false);  
        }
    }

    useFocusEffect(
        useCallback(() => {
            getDados();            
            return () => {
                setLoading(true);
                setError(false);
            }
        }, [])
    );

    const getCarteira = (dados, index) => dados[index];
    const getCarteiraCount = (dados) => dados.length;

    const rendercarteira = ({ item }) => (
        <TouchableOpacity onPress={() => navigation.navigate("Carteira", setIdcadastro(item.id_cadastro), setNome(item.nome))}>
                <View style={styles.divInfo}>
                    <View style={styles.divTopo}>
                        <View style={styles.divImg}></View>
                        <View style={styles.divDados}>
                            <View style={styles.label1}>
                                <Text>Nome: {item.nome} </Text>
                                <Text>Cpf: {item.cpf} </Text>
                                <Text>SUS: {item.docSUS} </Text>
                                <Text>Data de nasc: {item.dataNasc} </Text>
                            </View>
                        </View>
                    </View>
                    <View style={styles.divBaixo}>
                        <View style={styles.proxVacina}>
                            <Text>Descrição da proxima vacina</Text>
                        </View>
                    </View>
                </View>
            </TouchableOpacity>
    );

    return (
        <View style={styles.principal}>
            <View style={styles.divText}>
                <View style={styles.divButton}>
                    <TouchableOpacity onPress={() => navigation.navigate("MenuConfig")} style={styles.botao}>
                        <Image source={require("../imagens/kisspng-user-profile-computer-icons-profile-5ac0924526cda6.172054181522569797159 (1).png")} />
                    </TouchableOpacity>
                </View>
                <View style={styles.textoCarteira}>
                    <Text style={styles.textTitle}> Minhas carteiras</Text>
                </View>
            </View>
            <SafeAreaView style={styles.container}>
                {loading ? (
                    <Text>Procurando informações das carteiras</Text>
                ) : error ? (
                    <Text>Sem carteiras cadastradas</Text>
                ) : (
                    <VirtualizedList
                    data={dados}
                    initialNumToRender={100}
                    renderItem={rendercarteira}
                    keyExtractor={(carteira) => carteira.id_cadastro.toString()}
                    getItem={getCarteira}
                    getItemCount={getCarteiraCount}
                    />
                )}
            </SafeAreaView>
            <View style={styles.divCriar}>
                <TouchableOpacity onPress={() => navigation.navigate("CarteiraCadastro")} style={styles.botao2}>
                    <Image source={require("../imagens/kisspng-white-house-johns-hopkins-university-website-servi-white-cross-5ab020e49e7627.0961720415214921966491 (2).png")}
                    />
                </TouchableOpacity>
            </View>
        </View>
    );





}