import React, { useState} from "react";
import { View, Text, TouchableOpacity} from "react-native";

import { useNavigation } from "@react-navigation/native";

import styles from './style';

export default function Cadastro(){
    //função usada em botões para trocar de tela
    const navigation = useNavigation();
    //const [textButton, setTextButton] = useState("Acessar");


    return(
        <View>
            <View>
                <Text style={styles.textTitle}>pagina do Cadastro</Text>

                    <TouchableOpacity
                    style={styles.buttonAcessar}
                    onPress={() => navigation.navigate("Home")}
                    >
                        <Text style={styles.textButtonAcessar}>Confimar cadastro - Pagina HOME</Text>
                    </TouchableOpacity>
                   
                    <TouchableOpacity
                    style={styles.buttonAcessar}
                    onPress={() => navigation.navigate("Main")}
                    >
                        <Text style={styles.textButtonAcessar}>Volta - Pagina Login</Text>
                    </TouchableOpacity>

            </View>
        </View>
        
    )


}