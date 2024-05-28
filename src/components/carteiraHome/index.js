import React, { useState } from "react";
import { View, Text, TouchableOpacity, Image, } from "react-native";

import { useNavigation } from "@react-navigation/native";

import styles from './style';

export default function CarteiraHome() {
    //função usada em botões para trocar de tela
    const navigation = useNavigation();
    //const [textButton, setTextButton] = useState("Acessar");


    return (
        <View style={styles.principal}>
            <View style={styles.divText}>
                <View style={styles.divButton}>
                    <TouchableOpacity onPress={() => navigation.navigate("MenuConfig")} style={styles.botao}>
                        <Image source={require("../imagens/kisspng-user-profile-computer-icons-profile-5ac0924526cda6.172054181522569797159 (1).png")} />
                    </TouchableOpacity>
                </View>
                <View style={styles.textoCarteira}>
                    <Text style={styles.textTitle}> Minha carteira</Text>
                </View>
            </View>
            <TouchableOpacity onPress={() => navigation.navigate("Carteira")}>
                <View style={styles.divInfo}>
                    <View style={styles.divTopo}>
                        <View style={styles.divImg}></View>
                        <View style={styles.divDados}>
                            <View style={styles.label1}>
                                <Text>Nome : João </Text>
                                <Text>Idade : 3</Text>
                            </View>
                        </View>
                    </View>
                    <View style={styles.divBaixo}>
                        <View style={styles.proxVacina}>
                            <Text>Descrição Da Vacina</Text>
                        </View>
                    </View>
                </View>
            </TouchableOpacity>
            <View style={styles.divCriar}>
                <TouchableOpacity onPress={() => navigation.navigate("CarteiraCadastro")} style={styles.botao2}>
                    <Image source={require("../imagens/kisspng-white-house-johns-hopkins-university-website-servi-white-cross-5ab020e49e7627.0961720415214921966491 (2).png")}
                    />
                </TouchableOpacity>
            </View>
        </View>
    );





}