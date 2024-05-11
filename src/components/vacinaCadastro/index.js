import React, { useState} from "react";
import { View, Text, TouchableOpacity} from "react-native";

import { useNavigation } from "@react-navigation/native";

import styles from './style';

export default function VacinaCadastro(){
    //função usada em botões para trocar de tela
    const navigation = useNavigation();
    //const [textButton, setTextButton] = useState("Acessar");


    return(
        <View>
            <View>
                <Text style={styles.textTitle}>pagina Vacina cadastro</Text>

                    <TouchableOpacity
                    style={styles.buttonAcessar}
                    onPress={() => navigation.navigate("Home")}
                    >
                        <Text style={styles.textButtonAcessar}>Volta pagina Home</Text>
                    </TouchableOpacity>   

                    <TouchableOpacity
                    style={styles.buttonAcessar}
                    onPress={() => navigation.navigate("CarteiraCadastro")}
                    >
                        <Text style={styles.textButtonAcessar}>Voltar para Cadastro carteira</Text>
                    </TouchableOpacity>           

            </View>
        </View>
        
    )


}